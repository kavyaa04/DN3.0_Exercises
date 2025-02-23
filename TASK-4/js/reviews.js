// document.addEventListener("DOMContentLoaded", function () {
//     const urlParams = new URLSearchParams(window.location.search);
//     const movieTitle = urlParams.get("title") || "This Movie";  // Default if no title
//     document.getElementById("movieTitle").innerText = "Write a Review About " + movieTitle;
// });

// // Array to store reviews
// let reviews = [];
// let currentIndex = 0;

// // Submit Review
// document.getElementById("submitReview").addEventListener("click", function () {
//     const name = document.getElementById("name").value.trim();
//     const reviewText = document.getElementById("reviewText").value.trim();

//     if (name === "" || reviewText === "") {
//         alert("Please enter both your name and review.");
//         return;
//     }

//     reviews.push({ name, reviewText });
//     document.getElementById("name").value = "";
//     document.getElementById("reviewText").value = "";

//     displayReviews();
// });

// // Function to display reviews
// function displayReviews() {
//     const reviewsContainer = document.getElementById("reviewsContainer");

//     if (reviews.length === 0) {
//         reviewsContainer.innerHTML = "No reviews yet.";
//     } else {
//         reviewsContainer.innerHTML = `<p><strong>${reviews[currentIndex].name}:</strong> ${reviews[currentIndex].reviewText}</p>`;
//     }
// }

// // Next Review
// function nextReview() {
//     if (reviews.length > 0) {
//         currentIndex = (currentIndex + 1) % reviews.length;
//         displayReviews();
//     }
// }

// // Previous Review
// function prevReview() {
//     if (reviews.length > 0) {
//         currentIndex = (currentIndex - 1 + reviews.length) % reviews.length;
//         displayReviews();
//     }
// }

// // Load initial reviews
// displayReviews();

document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const movieTitle = urlParams.get("title") || "This Movie";  
    document.getElementById("movieTitle").innerText = "Write a Review About " + movieTitle;
});

document.getElementById("submitReview").addEventListener("click", function () {
    const name = document.getElementById("name").value.trim();
    const reviewText = document.getElementById("reviewText").value.trim();
    const reviewsContainer = document.getElementById("reviewsContainer");

    if (name === "" || reviewText === "") {
        alert("Please enter both your name and review.");
        return;
    }

    // Create a new review element
    const reviewElement = document.createElement("div");
    reviewElement.classList.add("review-item");
    reviewElement.innerHTML = `<p><strong>${name}:</strong> ${reviewText}</p>`;

    // Append the new review at the top
    reviewsContainer.prepend(reviewElement);

    // Clear input fields
    document.getElementById("name").value = "";
    document.getElementById("reviewText").value = "";
});
