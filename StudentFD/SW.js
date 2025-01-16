// Enhanced setupFileUpload function
function setupFileUpload(realFileBtnId, customBtnId, customTxtId) {
    const realFileBtn = document.getElementById(realFileBtnId);
    const customBtn = document.getElementById(customBtnId);
    const customTxt = document.getElementById(customTxtId);

    customBtn.addEventListener("click", () => realFileBtn.click());
    realFileBtn.addEventListener("change", () => {
        if (realFileBtn.files && realFileBtn.files[0]) {
            const file = realFileBtn.files[0];
            customTxt.textContent = file.name;
            customTxt.classList.add("file-chosen");
        } else {
            customTxt.textContent = "No File Chosen, Yet.";
            customTxt.classList.remove("file-chosen");
            alert("Please choose a file.");
        }
    });
}

// Error Popup Function
function showErrorPopup(buttonElement, errorMessage) {
    // Remove existing error popup if any
    const existingPopup = buttonElement.parentElement.querySelector('.error-popup');
    if (existingPopup) {
        existingPopup.remove();
    }

    // Create and append a new error popup
    const popup = document.createElement('div'); // Use 'div' for compatibility
    popup.classList.add('error-popup');
    popup.textContent = errorMessage;
    buttonElement.parentElement.appendChild(popup);
}

// Hide Error Popup
function hideErrorPopup(buttonElement) {
    const existingPopup = buttonElement.parentElement.querySelector('.error-popup');
    if (existingPopup) {
        existingPopup.remove();
    }
}

// Show Error Messages for Input Fields
function showErrorMessage(input, message) {
    const errorElement = document.getElementById(input.id + "-error");
    if (errorElement) {
        errorElement.textContent = message;
        errorElement.style.display = 'inline';
        input.classList.add("error");
    } else {
        console.error("Error element not found for:", input.id);
    }
}

// Hide all error messages
function hideErrorMessages() {
    document.querySelectorAll(".error").forEach(input => input.classList.remove("error"));
    document.querySelectorAll(".error-message").forEach(message => message.style.display = 'none');
}

// Function to validate individual fields
function validateField(field, regex, errorMessage) {
    if (!regex.test(field.value)) {
        showErrorMessage(field, errorMessage);
        return false;
    }
    return true;
}

// Initialize File Uploads
setupFileUpload("real-file-aadhar", "custom-button-aadhar", "custom-text-aadhar");
setupFileUpload("real-file-aadharB", "custom-button-aadharB", "custom-text-aadharB");
setupFileUpload("real-file-photo", "custom-button-photo", "custom-text-photo");

// Form Submission with Validation and File Upload Handling
const form = document.getElementById("registrationForm");
const submitBtn = document.getElementById("submit-btn2");

form.addEventListener("submit", async function (e) {
    e.preventDefault(); // Prevent default form submission

    let valid = true;
    let errorMessages = [];

    // Clear previous error messages
    document.querySelectorAll('.error-popup').forEach(popup => popup.remove());
    hideErrorMessages();

    // Validate email and phone fields
    const emailField = document.getElementById("email");
    const phoneField = document.getElementById("phone");

    valid &= validateField(emailField, /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/, "Invalid email address.");
    valid &= validateField(phoneField, /^[0-9]{10}$/, "Invalid phone number.");

    // Validate file uploads
    if (!document.getElementById("real-file-aadhar").files.length) {
        errorMessages.push("Please upload Aadhar Card Front.");
        showErrorPopup(document.getElementById("custom-button-aadhar"), "Please upload Aadhar Card Front");
        valid = false;
    }
    if (!document.getElementById("real-file-aadharB").files.length) {
        errorMessages.push("Please upload Aadhar Card Back.");
        showErrorPopup(document.getElementById("custom-button-aadharB"), "Please upload Aadhar Card Back");
        valid = false;
    }
    if (!document.getElementById("real-file-photo").files.length) {
        errorMessages.push("Please upload student photo.");
        showErrorPopup(document.getElementById("custom-button-photo"), "Please upload student photo");
        valid = false;
    }

    // Validate required select fields
    const selectFields = ["district", "relationType", "transportation", "course", "accommodationType"];
    selectFields.forEach(id => {
        const selectField = document.querySelector(`[name="${id}"]`);
        if (!selectField || selectField.value === "" || selectField.value === "Select") {
            showErrorMessage(selectField, "Please select an option");
            valid = false;
        }
    });

    if (!valid) {
        alert("Please fill the complete form: \n" + errorMessages.join("\n"));
        return; // Prevent form submission if validation fails
    }

    // If form is valid, proceed with submission
    submitBtn.disabled = true;
    submitBtn.value = "Processing...";

    const formData = new FormData(form); // Automatically handles files and text inputs

    try {
        const response = await fetch('http://localhost:8080/api/student/register', {
            method: 'POST',
            body: formData // Send FormData directly
        });

        if (response.ok) {
            const data = await response.json();
            displayPopup(data.message); // Show success message
            form.reset(); // Reset the form fields
        } else {
            const errorData = await response.json();
            alert("Registration Failed: " + errorData.message); // Show backend error message
        }
    } catch (error) {
        console.error("Error during registration:", error);
        alert("An error occurred while processing your registration.");
    } finally {
        submitBtn.disabled = false; // Re-enable submit button
        submitBtn.value = "Submit";
    }
});

// Function to show the popup
function displayPopup(message) {
    document.getElementById("popup-message").textContent = message;
    document.getElementById("popup").style.display = "block"; // Show popup
    document.getElementById("overlay").style.display = "block"; // Show overlay
}

// Function to close the popup
function closePopup() {
    document.getElementById("popup").style.display = "none";
    document.querySelector(".overlay").style.display = "none";
}

// Dynamic Cost Calculation
document.addEventListener("DOMContentLoaded", function () {
    const transportation = document.getElementById("transportSelect");
    const yearSelect = document.getElementById("yearSelect");
    const dayScholarHosteller = document.getElementById("DHSelect");

    const transportPaymentSection = document.getElementById("transportPaymentSection");
    const transportPaymentCost = document.getElementById("transportPaymentCost");
    const transportPaymentInput = document.getElementById("transportPaymentInput");

    const paymentSection = document.getElementById("paymentSection");
    const coursePaymentCost = document.getElementById("paymentCost");
    const coursePaymentInput = document.getElementById("coursePaymentInput");

    const DHPaymentSection = document.getElementById("DHPaymentSection");
    const DHPayment = document.getElementById("DHPaymentCost");
    const DHPaymentInput = document.getElementById("DHPaymentInput");

    function updateCost() {
        const transportOption = transportation.options[transportation.selectedIndex];
        const transportCost = transportOption ? parseInt(transportOption.getAttribute('data-fee')) : 0;

        const courseOption = yearSelect.options[yearSelect.selectedIndex];
        const courseCost = courseOption ? parseInt(courseOption.getAttribute('data-fee')) : 0;

        const DHOption = dayScholarHosteller.options[dayScholarHosteller.selectedIndex];
        const DHCost = DHOption ? parseInt(DHOption.getAttribute('data-fee')) : 0;

        transportPaymentSection.style.display = "block";
        transportPaymentCost.textContent = `INR₹ ${transportCost}`;
        transportPaymentInput.value = transportCost;

        paymentSection.style.display = courseCost > 0 ? "block" : "none";
        coursePaymentCost.textContent = courseCost > 0 ? `INR₹ ${courseCost}` : "";
        coursePaymentInput.value = courseCost;

        DHPaymentSection.style.display = "block";
        DHPayment.textContent = `INR₹ ${DHCost}`;
        DHPaymentInput.value = DHCost;
    }

    transportation.addEventListener("change", updateCost);
    yearSelect.addEventListener("change", updateCost);
    dayScholarHosteller.addEventListener("change", updateCost);

    updateCost(); // Initial call
});
