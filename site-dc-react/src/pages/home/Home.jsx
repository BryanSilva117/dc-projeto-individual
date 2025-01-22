import React, { useState } from "react";
import styles from "./Home.module.css";
import NavBar from "../../components/navbar/Navbar";
import ComicPanel from "../../components/comicPanel/ComicPanel";
import { FaChevronLeft, FaChevronRight } from "react-icons/fa"; 
import dcLogo from "../../utils/assets/dc-logo.png";

const panels = [
    {
        title: "A Origem da DC Comics",
        text: "A DC Comics foi fundada em 1934, revolucionando o mundo dos quadrinhos com a criação do Superman!",
        image: dcLogo
    },
    {
        title: "Os Maiores Heróis",
        text: "Batman, Superman, Mulher-Maravilha e Flash formam a base da Liga da Justiça!",
        image: dcLogo
    },
    {
        title: "Os Vilões Lendários",
        text: "Coringa, Lex Luthor e Darkseid são alguns dos vilões mais icônicos da DC.",
        image: dcLogo
    },
    {
        title: "O Multiverso DC",
        text: "Diferentes versões dos heróis coexistem no Multiverso, expandindo as possibilidades das histórias.",
        image: dcLogo
    }
];

const Home = () => {
    const [currentIndex, setCurrentIndex] = useState(0);

    // Função para avançar no carrossel
    const nextPanel = () => {
        setCurrentIndex((prevIndex) =>
            prevIndex === panels.length - 1 ? 0 : prevIndex + 1
        );
    };

    // Função para voltar no carrossel
    const prevPanel = () => {
        setCurrentIndex((prevIndex) =>
            prevIndex === 0 ? panels.length - 1 : prevIndex - 1
        );
    };

    return (
        <>
            <div className={styles["div-nav"]}>
                <NavBar />
            </div>

            <header id="Home">
                <div className={styles["header-content"]}>
                    <h1>BEM-VINDO AO UNIVERSO DC!</h1>
                    <div className={styles["text-home"]}>
                        <p>
                            Se aprofunde nesse universo recheado de conteúdos e descubra
                            qual será seu herói (ou vilão), favorito dessa incrível editora
                            chamada Detective Comics.
                        </p>
                    </div>
                </div>
            </header>

            <div className={styles["parte-sobre"]}>
                <div className={styles.carousel}>
                    <button className={styles.arrow} onClick={prevPanel}>
                        <FaChevronLeft />
                    </button>

                    <div className={styles["carousel-content"]}>
                        {panels.map((panel, index) => (
                            <div
                                key={index}
                                className={`${styles.panel} ${index === currentIndex ? styles.active : styles.hidden}`}
                            >
                                <ComicPanel
                                    title={panel.title}
                                    text={panel.text}
                                    image={panel.image}
                                />
                            </div>
                        ))}
                    </div>

                    <button className={styles.arrow} onClick={nextPanel}>
                        <FaChevronRight />
                    </button>
                </div>

                <div className={styles.indicators}>
                    {panels.map((_, index) => (
                        <span
                            key={index}
                            className={`${styles.dot} ${index === currentIndex ? styles.activeDot : ""}`}
                            onClick={() => setCurrentIndex(index)}
                        />
                    ))}
                </div>
            </div>
        </>
    );
};

export default Home;
