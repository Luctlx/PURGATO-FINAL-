<?php
// Configurações de conexão com o banco de dados
$host = "http://127.0.0.1/";
$usuario_bd = "sa";
$senha_bd = "@ITB123456";
$nome_bd = "BDPurgato";

// Conectando ao banco de dados
$conexao = mysqli_connect($host, $usuario_bd, $senha_bd, $nome_bd);

if (!$conexao) {
    die("Erro na conexão com o banco de dados: " . mysqli_connect_error());
}

// Resto do código para processar o formulário e realizar consultas ao banco de dados

// Verificar se o formulário foi enviado
    if (isset($_POST['submit'])) {
// Recuperando os valores do formulário
    $usuario = $_POST['usuario'];
    $senha = $_POST['senha'];

// Consulta SQL para verificar as credenciais
    $sql = "SELECT * FROM Funcionarios WHERE nome = '$usuario' AND senha = '$senha'";
    $resultado = mysqli_query($conexao, $sql);

    // Verificando se a consulta retornou algum resultado
    if (mysqli_num_rows($resultado) == 1) {
        // Credenciais válidas, redirecionar para a página de boas-vindas
        header("Location: telainicial.html");
        exit; // Importante: encerrar o script para evitar a execução de mais código
    } else {
        // Credenciais inválidas, exibir um alerta
        echo "<script>alert('Usuário ou senha inválidos!');</script>";
    }
}
