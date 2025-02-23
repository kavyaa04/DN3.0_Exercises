const apiKey = "3f72fb498ffdb11807f4b029c2084e9b";
const movieSlider = document.getElementById("movie-slider");

// Fetch 5 random movies from TMDB API
async function fetchRandomMovies() {
    try {
        const response = await fetch(`https://api.themoviedb.org/3/movie/popular?api_key=${apiKey}`);
        const data = await response.json();
        
        if (!data.results || data.results.length === 0) {
            console.error("No movies found.");
            return;
        }

        const movies = data.results.sort(() => 0.5 - Math.random()).slice(0, 5); // Pick 5 random movies
        movieSlider.innerHTML = ""; // Clear previous content

        movies.forEach(movie => {
            if (movie.poster_path) { // Ensure image exists
                let div = document.createElement("div");
                div.className = "movie-card";
                div.innerHTML = `
                    <img src="https://image.tmdb.org/t/p/w200${movie.poster_path}" alt="${movie.title}" onclick="goToMovieDetails(${movie.id})">
                `;
                movieSlider.appendChild(div);
            }
        });
    } catch (error) {
        console.error("Error fetching movies:", error);
    }
}

// Redirect to movie details page
function goToMovieDetails(movieId) {
    window.location.href = `movie-details.html?id=${movieId}`;
}

// Load movies when page loads
fetchRandomMovies();


