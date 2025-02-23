const API_KEY = '3f72fb498ffdb11807f4b029c2084e9b';
const API_URL = `https://api.themoviedb.org/3/movie/popular?api_key=${API_KEY}&language=en-US&page=1`;

document.addEventListener("DOMContentLoaded", async () => {
    const moviesContainer = document.getElementById("movies-container");
    const response = await fetch(API_URL);
    const data = await response.json();
    data.results.forEach(movie => {
        const movieElement = `
            <div class="movie">
                <img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}">
                <h3>${movie.title}</h3>
            </div>`;
        moviesContainer.innerHTML += movieElement;
    });
});
