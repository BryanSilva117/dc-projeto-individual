var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function (req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function (req, res) {
    usuarioController.listar(req, res);
});

//Recebendo os dados do html e direcionando para a função cadastrar de usuarioController.js
router.post("/cadastrar", function (req, res) {
    usuarioController.cadastrar(req, res);
})

router.post("/biografia", function (req, res) {
    usuarioController.biografia(req, res);
})

router.get("/plotarB/:idAquario", function (req, res) {
    usuarioController.plotarB(req, res);
});

router.get("/deletar/:idAquario", function (req, res) {
    usuarioController.deletar(req, res);
});

router.get("/deletar1/:idAquario", function (req, res) {
    usuarioController.deletar1(req, res);
});

router.get("/deletar2/:idAquario", function (req, res) {
    usuarioController.deletar2(req, res);
});

router.post("/autenticar", function (req, res) {
    usuarioController.entrar(req, res);
});

module.exports = router;