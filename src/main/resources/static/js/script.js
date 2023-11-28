const formCadastroUsuario = document.querySelector("#formCadastroUsuario");
const nomeUsuario = document.querySelector("#nomeUsuario");
const senha = document.querySelector("#senha");
const dataNascimento = document.querySelector("#dataNascimento");
const cpf = document.querySelector("#cpf");

const formCadastroRemedio = document.querySelector("#formCadastroRemedio");
const nomeRemedio = document.querySelector("#nomeRemedio");
const descricao = document.querySelector("#descricao");
const valor = document.querySelector("#valor");

const pix = document.querySelector("#pix");
const campoPix = document.querySelector("#campoPix");
const telefonePix = document.querySelector("#telefonePix");
const cartaoCredito = document.querySelector("#cartaoCredito");
const campoCredito = document.querySelector("#campoCredito");
const numeroCredito = document.querySelector("#numeroCredito");
const codigoCredito = document.querySelector("#codigoCredito");
const parcelaCredito = document.querySelector("#parcelaCredito");
const botaoPagamento = document.querySelector("#botaoPagamento");
const formEfetuarPagamento = document.querySelector("#formEfetuarPagamento");

const qtdRemedio = document.querySelector("#qtdRemedio").defaultValue = 1;

if (formCadastroUsuario) {
    formCadastroUsuario.addEventListener("submit", function () {
        //para não ocorrer submit
        event.preventDefault();

        if (nomeUsuario.value === "") {
            alert("Insira o campo nome corretamente.");
            return;
        }

        if (senha.value.length < 6) {
            alert("Insira uma senha de ao menos 6 caracteres.");
            return;
        }

        if (dataNascimento.value === "") {
            alert("Insira o campo data corretamente.");
            return;
        }

        if (cpf.value === "" || cpf.value.length < 14 || cpf.value.length > 14) {
            alert("Insira o campo cpf corretamente.");
            return;
        }

        //se todos os campos estiverem corretos
        formCadastroUsuario.submit();
        alert("Usuário cadastrado com sucesso!");
    });
}

if (formCadastroRemedio) {
    formCadastroRemedio.addEventListener("submit", function () {
        event.preventDefault();

        if (nomeRemedio.value === "") {
            alert("Insira o campo nome do remédio corretamente.");
            return;
        }
        ;

        if (descricao.value === "") {
            alert("Insira o campo descrição corretamente.");
            return;
        }
        ;

        if (valor.value <= 0.0) {
            alert("Insira o campo valor corretamente.");
            return;
        }
        ;

        formCadastroRemedio.submit();
        alert("Remédio cadastrado com sucesso!");
    });
}

pix.addEventListener("click", function () {
    formEfetuarPagamento.style.display = "block";
    campoCredito.style.display = "none";
    campoPix.style.display = "block";
    botaoPagamento.style.display = "block";
});

cartaoCredito.addEventListener("click", function () {
    formEfetuarPagamento.style.display = "block";
    campoPix.style.display = "none";
    campoCredito.style.display = "block";
    botaoPagamento.style.display = "block";
});

formEfetuarPagamento.addEventListener("submit", function () {
    event.preventDefault();

    if (telefonePix.value === "" && pix.checked) {
        alert("Insira o campo telefone corretamente.");
        return;
    }

    if (numeroCredito.value === "" && cartaoCredito.checked) {
        alert("Insira o campo número corretamente.");
        return;
    }

    if (codigoCredito.value === "" && cartaoCredito.checked) {
        alert("Insira o campo Cód. Segurança corretamente.");
        return;
    }

    if (parcelaCredito.value === "Escolha o número de parcelas" && cartaoCredito.checked) {
        alert("Escolha quantas vezes parcelar.");
        return;
    }

    alert("Pagamento bem-sucedido :)");

    formEfetuarPagamento.submit();
});