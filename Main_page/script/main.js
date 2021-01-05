
const container = document.querySelector('#container');
const url = './data.json';
axios.get(url)
    .then(function (res) {
        console.log(res.data);

        res.data.forEach(function(obj) {
            const el = createEl(obj);
            container.append(el);
        });
    });

function createEl(obj) {
    var el = document.createElement('div');
    el.className = 'item';
    el.innerHTML = `
        <img src="${obj.file_path}" alt="image - ${obj.title}">
        <div>
            <strong>${obj.title}</strong>
            <span>${obj.author_name}</span>
        </div>
    `;

    el.onclick = function() {
        setModal(obj);
        showModal();
    };

    return el;
}

function setModal(obj) {
    const modal = document.getElementById('modal_inner');
    modal.innerHTML = `
    <h2>${obj.title}</h2>
    <strong>${obj.author_name}</strong>
    <img src="${obj.file_path}" alt="image - ${obj.title}">
    <p>${obj.description}</p>
    <small>${obj.regdate}</small>
    <a href="${obj.file_path}" download>📥Download Image</a>
    `;
}

const modal = document.getElementById('modal');
modal.onclick = hideModal;

function showModal() {
    modal.classList.remove('hide');
    bttbtn.style.display = "none";
}

function hideModal(e) {
    if(e.target == modal) {
        modal.classList.add('hide');
    }
    bttbtn.style.display = "block";
}



const bttbtn = document.querySelector('#bttbtn');
bttbtn.onclick = backtotop;

function backtotop() {
    window.scroll(null, 0);
}

// window.onscroll = function() {scrollFunction()};

// function scrollFunction() {
//   if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
//     bttbtn.style.display = "block";
//   } else {
//     bttbtn.style.display = "none";
//   }
// }