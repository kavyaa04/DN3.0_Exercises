// const movies = [
//     {title: "Mufasa", year: 2024, rating: "8.5", genre: "Adventure", description: "A thrilling journey of the Lion King.", image: "mufasa.jpg"},
//     {title: "Avatar", year: 2022, rating: "9.0", genre: "Sci-Fi", description: "A visually stunning alien world.", image: "avatar.jpg"}
// ];

// const movieSlider = document.getElementById("movie-slider");
// movies.forEach(movie => {
//     let div = document.createElement("div");
//     div.className = "movie-card";
//     div.innerHTML = `<img src="${movie.image}" onclick="showMovieDetails('${movie.title}')">`;
//     movieSlider.appendChild(div);
// });

// document.getElementById("right-arrow").addEventListener("click", () => {
//     movieSlider.scrollLeft += 200;
// });

// document.getElementById("left-arrow").addEventListener("click", () => {
//     movieSlider.scrollLeft -= 200;
// });

// function searchMovie() {
//     let query = document.getElementById("search-box").value.toLowerCase();
//     let foundMovie = movies.find(movie => movie.title.toLowerCase().includes(query));
//     if (foundMovie) {
//         document.getElementById("movie-slider").innerHTML = `<img src="${foundMovie.image}" onclick="showMovieDetails('${foundMovie.title}')">`;
//     }
// }

// function showMovieDetails(title) {
//     let movie = movies.find(m => m.title === title);
//     localStorage.setItem("selectedMovie", JSON.stringify(movie));
//     window.location.href = "movie_details.html";
// }

// function goToReviews() {
//     window.location.href = "reviews.html";
// }

// function submitReview() {
//     let reviewText = document.getElementById("review-input").value;
//     if (reviewText) {
//         let reviewDiv = document.createElement("div");
//         reviewDiv.textContent = reviewText;
//         document.getElementById("reviews-container").appendChild(reviewDiv);
//     }
// }
