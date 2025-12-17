const BASE_URL = window.location.origin;

const joinForm = document.getElementById("joinForm");
const roomInput = document.getElementById("roomInput");
const createBtn = document.getElementById("createRoomBtn");

joinForm.addEventListener("submit", async evt => {
  evt.preventDefault();

  const room = roomInput.value.trim();
  if (!room) {
    alert("Plz!! Enter the room id");
    return;
  }

  const exists = await roomExists(room);

  if (!exists) {
    alert("Room does not exist!");
    return;
  }

  window.location.href = `${BASE_URL}/?room=${room}`;
});

createBtn.addEventListener("click", () => {
  const room = roomInput.value.trim();
  if (!room) {
    alert('Plz!! Enter the room id');
    return;
  }
  window.location.href = `${BASE_URL}/?room=${room}`;
});
async function roomExists(room) {
  const res = await fetch(`/check-room?room=${room}`);
  const data = await res.json();
  return data.exists;
}
