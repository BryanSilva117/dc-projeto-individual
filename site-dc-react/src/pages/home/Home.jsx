
import React from "react";
import styles from "./Home.module.css";
import NavBar from "../../components/navbar/Navbar";
import Api from "../../api";

const Home = () => {
    return (

        <>

            <div className={styles["div-nav"]}>
                <NavBar />
            </div>

            <header id="Home">
                <div className={styles["header-content"]}>
                    <h1>BEM VINDO AO UNIVERSO DC!</h1>
                    <div className={styles["text-home"]}>
                        <p>Se aprofunde nesse universo
                            recheado de conteúdos e descubra
                            qual será seu herói (ou vilão),
                            favorito dessa incrível editora
                            chamada Detective Comics</p>
                    </div>
                </div>
            </header>

            <div className={styles["parte-sobre"]}>

                <div className={styles["container-quadrinhos"]}>
                    <div className={styles["primeiro-quadro"]}>
                        <div className={styles["info-card"]}>

                        </div>
                    </div>
                    <div className={styles["quadro-viloes"]}>
                        
                    </div>
                    <div className={styles["segundo-quadro"]}>
                        <div className={styles["info-card"]}>

                        </div>
                    </div>
                </div>

            </div>

        </>
    );
};

export default Home;
