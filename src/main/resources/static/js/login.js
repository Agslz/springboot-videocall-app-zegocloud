function handleLogin(event) {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  const user = {
    email: email,
    password: password,
  };

  fetch("http://localhost:8080/api/v1/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  })
    .then((response) => {
      if (!response.ok) {
        Swal.fire({
          title: "Error",
          text: "Username or password is incorrect",
          icon: "error",
          confirmButtonColor: "#4CAF50",
        });
      }
      return response.json();
    })
    .then((response) => {
      localStorage.setItem("connectedUser", JSON.stringify(response));
      window.location.href = "index.html";
    })
    .catch((error) => {
      console.log("POST request error", error);
    });
}

const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", handleLogin);
