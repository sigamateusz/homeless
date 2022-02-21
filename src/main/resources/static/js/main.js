function validateRecord() {
    const addRecordModal = document.querySelector('#addRecordModal');
    const inputs = addRecordModal.querySelectorAll('input');
    const values = [];
    inputs.forEach(input => values.push(input.value));
    const isAnyInputEmpty = !values.every(value => !!value);

    if (isAnyInputEmpty) {
        addRecordModal.querySelector('#add-btn').setAttribute('disabled', isAnyInputEmpty);
    } else {
        addRecordModal.querySelector('#add-btn').removeAttribute('disabled');
    }
}

function closeModal() {
    document.getElementById('cancel-modal-btn').click();
}