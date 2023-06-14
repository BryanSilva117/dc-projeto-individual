var database = require("../database/config");

function buscarUltimasMedidas(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `select count(usuario.fkPersonagemFav) as voto, personagemFav.nomeP as personagem
        from usuario join personagemFav on personagemFav.idPersonagemFav = usuario.fkPersonagemFav 
            group by usuario.fkPersonagemFav;`;
    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select count(usuario.fkPersonagemFav) as voto, personagemFav.nomeP as personagem
        from usuario join personagemFav on personagemFav.idPersonagemFav = usuario.fkPersonagemFav 
            group by usuario.fkPersonagemFav;`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


function buscarUltimasMedidas2(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome as Nome, (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
        (SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada join usuario on fkUsuario = idUsuario
			group by fkUsuario order by  fkUsuario desc limit 5;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `SELECT nome as Nome, (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
        (SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada join usuario on fkUsuario = idUsuario
			group by fkUsuario order by  fkUsuario desc limit 5;`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


function buscarUltimasMedidas3(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
        (SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada where fkUsuario = ${idAquario};`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `SELECT (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
        (SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada where fkUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarUltimasMedidas4(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(acertos) / (COUNT(*) * 5)) * 100, 1) AS MediaAcertos FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaAcertos DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(acertos) / (COUNT(*) * 5)) * 100, 1) AS MediaAcertos FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaAcertos DESC, fkUsuario desc LIMIT 1;`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarUltimasMedidas5(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function fotosPerso(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select fkPersonagemFav as personagem from usuario where idUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function perfil(idAquario, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
        JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;`;


    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `SELECT usuario.nome AS NomeU, sobrenome, email, DATE_FORMAT(STR_TO_DATE(dtNasc, '%Y-%m-%d'), '%d/%m/%Y') AS dtNasc, Genero, personagemFav.nomeP AS Personagem
        FROM usuario
            JOIN personagemFav ON fkPersonagemFav = idPersonagemFav
                    WHERE idUsuario = ${idAquario};`;

    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasEmTempoReal(idAquario) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `select top 1
        dht11_temperatura as temperatura, 
        dht11_umidade as umidade,  
                        CONVERT(varchar, momento, 108) as momento_grafico, 
                        fk_aquario 
                        from medida where fk_aquario = ${idAquario} 
                    order by id desc`;

    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select 
        dht11_temperatura as temperatura, 
        dht11_umidade as umidade,
                        DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico, 
                        fk_aquario 
                        from medida where fk_aquario = ${idAquario} 
                    order by id desc limit 1`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


module.exports = {
    buscarUltimasMedidas,
    buscarUltimasMedidas2,
    buscarUltimasMedidas3,
    buscarUltimasMedidas4,
    buscarUltimasMedidas5,
    fotosPerso,
    perfil,
    buscarMedidasEmTempoReal
}
