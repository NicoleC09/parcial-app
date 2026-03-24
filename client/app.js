const form = document.getElementById("fibwin-form");
const valueInput = document.getElementById("value");
const result = document.getElementById("result");

const PROXY_BASE_URL = "http://localhost:8080";

form.addEventListener("submit", async (event) => {
  event.preventDefault();

  const value = Number(valueInput.value);
  if (!Number.isInteger(value) || value < 2) {
    result.textContent = "El valor debe ser un entero >= 2.";
    return;
  }

  result.textContent = "Cargando...";

  try {
    const response = await fetch(`${PROXY_BASE_URL}/fibwin?value=${value}`);
    const data = await response.json();

    if (!response.ok) {
      result.textContent = JSON.stringify(data, null, 2);
      return;
    }

    result.textContent = JSON.stringify(data, null, 2);
  } catch (error) {
    result.textContent = "No se pudo conectar con el proxy.";
  }
});
