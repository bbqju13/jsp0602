async function postCommToServer(cmtData) {
	try {
		const url = "/ccl/post";
		const config = {
			method: 'post',
			headers: {
				'content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmtData)
		};
		const resp = await fetch(url, config);
		const result = await resp.text();
		return result;

	} catch (err) {
		console.log(err);
	}
}

document.getElementById('cmtAddBtn').addEventListener('click', ()   => {
	const cmtText = document.getElementById('cmtText').value;
	console.log(cmtText);

	if (cmtText == null || cmtText == "") {
		alert('댓글을 입력해주세요.');
		return false;
	} else {
		let cmtData = {
			tno: tnoVal,
			writer: document.getElementById('cmtWriter').value,
			content: cmtText
		};
		postCommToServer(cmtData).then(result => {
			if (result > 0) {
				alert('댓글 등록 성공' + cmtData.content);
				document.getElementById('cmtText').value = "";
			}
			printCommList(cmtData.tno);
		})
	}
})

async function getCommListFromServer(tno) {
		try {
			const resp = await fetch('/ccl/list/' + tno);
			const cmtList = await resp.json();
			return cmtList;
		} catch (err) {
			console.log(err);
		}
	}

function printCommList(tno) {
		getCommListFromServer(tno).then(result => {
			console.log(result);
			if (result.length > 0) {
				spredCommList(result);
			} else {
				let div = document.getElementById('accordionExample');
				div.innerText = "Comment가 없습니다.";
			}
		})
	}

function spredCommList(result) {
		console.log(result);
		let div = document.getElementById('accordionExample');
		div.innerHTML = "";
		for (i = 0; i < result.length; i++) {

			let html = `<div class="accordion-item">`;

			html += `<h2 class="accordion-header" id="heading${i}">`;

			html += `<button class="accordion-button" type="button"
				data-bs-toggle="collapse" `;

			html += `data-bs-target="#collapse${i}"
				aria-expanded="true" aria-controls="collapse${i}">`;
			html += `${result[i].cno}, ${result[i].writer}</button></h2 >`;

			html += `<div id="collapse${i}" class="accordion-collapse collapse show"`;

			html += `aria-labelledby="heading${i}" data-bs-parent="#accordionExample">`;

			html += `<div class="accordion-body">`;

			html += `<button type="button" data-cno="${result[i].cno}" data-writer="${result[i].writer}" class="btn btn-sm btn-outline-warning cmtModBtn">수정</button>`;

			html += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">삭제</button>`;

			html += `<input type="text" class="form-control" id="cmtText1" value="${result[i].content}">`;

			html += `${result[i].reg_date}`;

			html += `</div></div></div>`;

			div.innerHTML += html;
		}

		async function removeCommFromServer(cnoVal) {
			try {
				const url = '/ccl/remove?cnoVal=' + cnoVal;
				const config = {
					method: 'post'
				}
				const resp = await fetch(url, config);
				const result = await resp.text();
				return result;

			} catch (err) {
				console.log(err);
			}
		}

		async function updateCommFromServer(cnoVal, cmtText1, writer) {
			try {
				const url = "/ccl/modify";
				const config = {
					method: "post",
					headers: {
						'Content-Type': 'application/json; charset=utf-8'
					},
					body: JSON.stringify({ cno: cnoVal, content: cmtText1, writer: writer })
				}
				const resp = await fetch(url, config);
				const result = await resp.text(); // isOk
				return result;
			} catch (err) {
				console.log(err);
			}
		}

		document.addEventListener('click', (e) => {
			if (e.target.classList.contains('cmtModBtn')) {

				let cnoVal = e.target.dataset.cno;
				console.log(cnoVal);
				let div = e.target.closest('div');
				let cmtText1 = div.querySelector('#cmtText1').value;
				let writer = e.target.dataset.writer;


				updateCommFromServer(cnoVal, cmtText1, writer).then(result => {
					if (result > 0) {
						alert('댓글 수정 성공 : ');
						console.log(result);
						printCommList(bnoVal);
					} else {
						alert('수정 불가 입니다.');
					}
				})
			}
			if (e.target.classList.contains('cmtDelBtn')) {
				// 삭제작업
				let cnoVal = e.target.dataset.cno;
				console.log(cnoVal);
				removeCommFromServer(cnoVal).then(result => {
					if (result > 0) {
						alert('댓글삭제 완료 : >> : ');
						printCommList(tnoVal);
						console.log(tnoVal);
					}
				})
			}
		})
	}


