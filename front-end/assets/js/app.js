document.addEventListener("DOMContentLoaded", () => {
    const modal = document.getElementById("task-modal");
    const taskList = document.getElementById("task-list");
    const filterOptions = document.getElementById("status-filter");

    let editingTask = null;

    function formatDateToDisplay(dateString) {
        const [year, month, day] = dateString.split("-");
        return `${day}/${month}/${year}`;
    }

    function formatDateToInput(dateString) {
        const [day, month, year] = dateString.split("/");
        return `${year}-${month}-${day}`;
    }

    window.openTaskModal = function () {
        modal.style.display = "flex";
        document.getElementById("modal-title").innerText = editingTask ? "Editar Tarefa" : "Adicionar Tarefa";
    };

    window.closeTaskModal = function () {
        modal.style.display = "none";
        clearModalFields();
    };

    window.saveTask = function () {
        const name = document.getElementById("task-name").value.trim();
        const desc = document.getElementById("task-desc").value.trim();
        const date = document.getElementById("task-date").value;
        const priority = document.getElementById("task-priority").value;
        const status = document.getElementById("task-status").value;

        if (!name || !desc || !date) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        const formattedDate = formatDateToDisplay(date);
        const taskData = { name, desc, date: formattedDate, priority, status };

        if (editingTask) {
            updateTask(editingTask, taskData);
        } else {
            addTask(taskData);
        }

        saveTasksToLocalStorage();
        closeTaskModal();
    };

    function addTask(task, save = true) {
        const taskCard = document.createElement("div");
        taskCard.classList.add("task-card");
        taskCard.innerHTML = `
            <h3>${task.name}</h3>
            <p>${task.desc}</p>
            <p><strong>Data:</strong> ${task.date}</p>
            <p><strong>Prioridade:</strong> ${task.priority}</p>
            <p><strong>Status:</strong> ${task.status}</p>
            <div class="icons">
                <i class="edit-btn" onclick="editTask(this)">✏️</i>
                <i class="delete-btn" onclick="deleteTask(this)">🗑️</i>
            </div>
        `;
        taskList.appendChild(taskCard);

        if (save) saveTasksToLocalStorage();
    }

    window.editTask = function (btn) {
        editingTask = btn.closest(".task-card");
        const paragraphs = editingTask.querySelectorAll("p");

        document.getElementById("task-name").value = editingTask.querySelector("h3").innerText;
        document.getElementById("task-desc").value = paragraphs[0].innerText;
        document.getElementById("task-date").value = formatDateToInput(paragraphs[1].innerText.split(": ")[1]);
        document.getElementById("task-priority").value = paragraphs[2].innerText.split(": ")[1];
        document.getElementById("task-status").value = paragraphs[3].innerText.split(": ")[1];

        openTaskModal();
    };

    function updateTask(taskElement, updatedTask) {
        taskElement.innerHTML = `
            <h3>${updatedTask.name}</h3>
            <p>${updatedTask.desc}</p>
            <p><strong>Data:</strong> ${updatedTask.date}</p>
            <p><strong>Prioridade:</strong> ${updatedTask.priority}</p>
            <p><strong>Status:</strong> ${updatedTask.status}</p>
            <div class="icons">
                <i class="edit-btn" onclick="editTask(this)">✏️</i>
                <i class="delete-btn" onclick="deleteTask(this)">🗑️</i>
            </div>
        `;
        saveTasksToLocalStorage();
    }

    function saveTasksToLocalStorage() {
        const tasks = Array.from(document.querySelectorAll(".task-card")).map(taskCard => ({
            name: taskCard.querySelector("h3").innerText,
            desc: taskCard.querySelector("p").innerText,
            date: taskCard.querySelector("p:nth-of-type(2)").innerText.split(": ")[1],
            priority: taskCard.querySelector("p:nth-of-type(3)").innerText.split(": ")[1],
            status: taskCard.querySelector("p:nth-of-type(4)").innerText.split(": ")[1],
        }));
        localStorage.setItem("tasks", JSON.stringify(tasks));
    }

    function loadTasksFromLocalStorage() {
        const tasks = JSON.parse(localStorage.getItem("tasks")) || [];
        tasks.forEach(task => addTask(task, false));
    }

    function clearModalFields() {
        document.getElementById("task-name").value = "";
        document.getElementById("task-desc").value = "";
        document.getElementById("task-date").value = "";
        document.getElementById("task-priority").value = "1";
        document.getElementById("task-status").value = "TODO";
        editingTask = null;
    }

    loadTasksFromLocalStorage();
});
