var database = require("../database/config")

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM usuario;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM usuario WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// Coloque os mesmos parâmetros aqui. Vá para a var instrucao
function cadastrar(nome,sobrenome, email, senha, dtNasc, genero, personagemFav) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, sobrenome, email, senha, dtNasc, genero, personagemFav);
    
    // Insira exatamente a query do banco aqui, lembrando da nomenclatura exata nos valores
    //  e na ordem de inserção dos dados.
    var instrucao = `
        INSERT INTO usuario (nome, sobrenome, email, senha, dtNasc, genero, fkPersonagemFav) VALUES ('${nome}', '${sobrenome}', '${email}', '${senha}', '${dtNasc}', '${genero}', '${personagemFav}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function atualizar(idAquario,nome,sobrenome, email, dtNasc, genero, personagemFav) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", idAquario, nome, sobrenome, email, dtNasc, genero, personagemFav);
    
    // Insira exatamente a query do banco aqui, lembrando da nomenclatura exata nos valores
    //  e na ordem de inserção dos dados.
    var instrucao = `
    UPDATE usuario
    SET nome = '${nome}', sobrenome = '${sobrenome}', email = '${email}', genero = '${genero}', dtNasc = '${dtNasc}', fkPersonagemFav = ${personagemFav}
    WHERE idUsuario = ${idAquario};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function biografia(biografia, idAquario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", biografia, idAquario);
    
    // Insira exatamente a query do banco aqui, lembrando da nomenclatura exata nos valores
    //  e na ordem de inserção dos dados.
    var instrucao = `
        INSERT INTO biografia (descricao, fkUsuario) VALUES ('${biografia}', '${idAquario}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function plotarB(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select descricao from biografia where fkUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function deletar(idAquario, limite_linhas) {

    instrucaoSql = ''
    

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `delete from biografia where fkUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
  
    return database.executar(instrucaoSql);
   
}

function deletar1(idAquario, limite_linhas) {

    instrucaoSql = ''
    

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `delete from quizCharada where fkUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
  
    return database.executar(instrucaoSql);
   
}

function deletar2(idAquario, limite_linhas) {

    instrucaoSql = ''
    

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {

        instrucaoSql = `delete from usuario where idUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
  
    return database.executar(instrucaoSql);
   
}

module.exports = {
    entrar,
    cadastrar,
    atualizar,
    biografia,
    plotarB,
    deletar,
    deletar1,
    deletar2,
    listar,
};