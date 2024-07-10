
import React, { useState, useEffect } from 'react';
import styles from './Navbar.module.css'
import DclogoAzul from '../../utils/assets/dc-logo-azul.png';
import JlLogoAzul from '../../utils/assets/jl-logo-azul.png';
import { useNavigate } from "react-router-dom";


const NavBar = () => {
    const navigate = useNavigate();
    const [rolagem, setRolagem] = useState(false);

    const home = () => {
        navigate("/");
    };

    const login = () => {
        navigate("/");
    };

    const cadastrar = () => {
        navigate("/");
    };

    const handleScroll = () => {
        if (window.scrollY > 0) {
            setRolagem(true);
        } else {
            setRolagem(false);
        }
    };

    useEffect(() => {
        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    return (

        <nav className={rolagem ? styles["navbar-moviment"] : styles["navbar"]} id='nav'>

            <div className={styles["parte-left"]}>
            <img src={DclogoAzul} className={styles["imagem-logo"]} alt="logo-dc" />
                <ul className={styles["navbar-options"]}>
                    <li><a className={styles["texto-left"]} title="Entre em contato com nos caso queira Contribuir" href="#contribuir">
                        QUER CONTRIBUIR?
                    </a></li>
                    <li><a className={styles["texto-left"]} href="#sobreDc">
                        SOBRE A DC
                    </a></li>
                </ul>
                <img src={JlLogoAzul} className={styles["jl"]} alt="logo-jl" />

            </div>

            <div className={styles["botoes"]}>
                <ul className={styles["navbar-options"]}>
                    <div className={styles["wrapper"]}>
                        <a onClick={login} ><span>LOGIN</span></a>
                        <a onClick={cadastrar} className={styles["cadastro"]}><span>CADASTRAR</span></a>
                    </div>
                    
                    
                </ul>
            </div>


        </nav >
    );
};

// Exporta o componente NavBar para que possa ser usado em outras partes da aplicação.
export default NavBar;
