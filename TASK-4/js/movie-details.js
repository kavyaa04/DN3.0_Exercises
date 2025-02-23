
// document.addEventListener("DOMContentLoaded", async () => {
//     const API_KEY = "3f72fb498ffdb11807f4b029c2084e9b";


document.addEventListener("DOMContentLoaded", async () => {
    const API_KEY = "3f72fb498ffdb11807f4b029c2084e9b";
    const MOVIE_ID = new URLSearchParams(window.location.search).get("id");
    const API_URL = `https://api.themoviedb.org/3/movie/${MOVIE_ID}?api_key=${API_KEY}&append_to_response=credits`;

    try {
        const response = await fetch(API_URL);
        const data = await response.json();

        document.getElementById("poster").src = `https://image.tmdb.org/t/p/w500${data.poster_path}`;
        document.getElementById("title").textContent = data.title;
        document.getElementById("duration").textContent = `${data.runtime} minutes`;
        document.getElementById("year").textContent = data.release_date.split("-")[0];
        document.getElementById("genre").textContent = data.genres.map(g => g.name).join(", ");
        document.getElementById("rating").textContent = data.vote_average.toFixed(1);
        document.getElementById("contentRating").textContent = data.adult ? "A+" : "U+";
        document.getElementById("description").textContent = data.overview;

        let stars = "⭐".repeat(Math.round(data.vote_average / 2));
        document.getElementById("stars").innerHTML = stars;

        const castContainer = document.getElementById("cast");
        data.credits.cast.slice(0, 5).forEach(actor => {
            const actorDiv = document.createElement("div");
            actorDiv.classList.add("cast-member");

            const actorImg = document.createElement("img");
            actorImg.src = actor.profile_path 
                ? `https://image.tmdb.org/t/p/w200${actor.profile_path}`
                : "https://via.placeholder.com/60";

            const actorName = document.createElement("p");
            actorName.textContent = actor.name;

            actorDiv.appendChild(actorImg);
            actorDiv.appendChild(actorName);
            castContainer.appendChild(actorDiv);
        });

        document.getElementById("reviewButton").addEventListener("click", () => {
            window.location.href = `reviews.html?id=${MOVIE_ID}`;
        });

    } catch (error) {
        console.error("Error fetching movie data:", error);
    }
});
