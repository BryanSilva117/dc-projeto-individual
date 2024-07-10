
import React from "react";
import styles from "./Home.module.css";
import NavBar from "../../components/navbar/Navbar";

const Home = () => {
    return (

        <>

        <div className={styles["div-nav"]}>
        <NavBar />
        </div>
        
            <header id="Home">
                <div className={styles["header-content"]}>
                    <div className={styles["text-home"]}>
                        
                    </div>
                </div>
            </header>

            <div className={styles["teste"]}>
              
            </div>

        </>
    );
};

export default Home;
