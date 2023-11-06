const formCadastroUsuario = document.querySelector("#formCadastroUsuario");
const nomeUsuario = document.querySelector("#nomeUsuario");
const senha = document.querySelector("#senha");
const dataNascimento = document.querySelector("#dataNascimento");
const cpf = document.querySelector("#cpf");

formCadastroUsuario.addEventListener("submit", function(){
    //para não ocorrer submit
    event.preventDefault();
    
    if(nomeUsuario.value === ""){
        alert("Insira o campo nome corretamente.");
        return;
    }
    
    if(senha.value.length < 6){
        alert("Insira uma senha de ao menos 6 caracteres.");
        return;
    }
    
    if(dataNascimento.value === ""){
        alert("Insira o campo data corretamente.");
        return;
    }
    
    if(cpf.value === "" || cpf.value.length < 14 || cpf.value.length > 14){
        alert("Insira o campo cpf corretamente.");
        return;
    }
    
    //se todos os campos estiverem corretos
    formCadastroUsuario.submit();
});