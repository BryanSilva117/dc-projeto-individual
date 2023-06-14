var express = require("express");
var router = express.Router();

var medidaController = require("../controllers/medidaController");

router.get("/ultimas/:idAquario", function (req, res) {
    medidaController.buscarUltimasMedidas(req, res);
});

router.get("/ultimas2/:idAquario", function (req, res) {
    medidaController.buscarUltimasMedidas2(req, res);
});

router.get("/ultimas3/:idAquario", function (req, res) {
    medidaController.buscarUltimasMedidas3(req, res);
});

router.get("/ultimas4/:idAquario", function (req, res) {
    medidaController.buscarUltimasMedidas4(req, res);
});

router.get("/ultimas5/:idAquario", function (req, res) {
    medidaController.buscarUltimasMedidas5(req, res);
});

router.get("/fotosPerso/:idAquario", function (req, res) {
    medidaController.fotosPerso(req, res);
});

router.get("/perfil/:idAquario", function (req, res) {
    medidaController.perfil(req, res);
});

router.get("/tempo-real/:idAquario", function (req, res) {
    medidaController.buscarMedidasEmTempoReal(req, res);
})

module.exports = router;