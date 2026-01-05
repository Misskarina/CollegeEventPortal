const API = "http://localhost:6564/api";

function register() {
    fetch(API + "/auth/register", {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify({
            name: rname.value,
            email: remail.value,
            password: rpassword.value,
            role: "ROLE_USER"
        })
    }).then(r => r.text()).then(alert);
}

function login() {
    fetch(API + "/auth/login", {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify({
            email: lemail.value,
            password: lpassword.value
        })
    }).then(r => r.text()).then(t => {
        localStorage.setItem("token", t);
        location.href = "dashboard.html";
    });
}

function loadEvents() {
    fetch(API + "/events", {
        headers: {"Authorization":"Bearer " + localStorage.getItem("token")}
    })
    .then(r => r.json())
    .then(data => {
        events.innerHTML = "";
        data.forEach(e => {
            const li = document.createElement("li");
            li.innerText = e.title;

            const b = document.createElement("button");
            b.innerText = "Delete";
            b.onclick = () => deleteEvent(e.id);

            li.appendChild(b);
            events.appendChild(li);
        });
    });
}

function createEvent() {
    fetch(API + "/events", {
        method: "POST",
        headers: {
            "Content-Type":"application/json",
            "Authorization":"Bearer " + localStorage.getItem("token")
        },
        body: JSON.stringify({
            title: title.value,
            description: "College Event",
            eventDate: "2026-01-10"
        })
    }).then(loadEvents);
}

function deleteEvent(id) {
    fetch(API + "/events/" + id, {
        method: "DELETE",
        headers: {"Authorization":"Bearer " + localStorage.getItem("token")}
    }).then(loadEvents);
}

function logout() {
    localStorage.removeItem("token");
    location.href = "index.html";
}

if (location.pathname.includes("dashboard")) loadEvents();
