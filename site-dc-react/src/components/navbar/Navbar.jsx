
import React from 'react';
import styles from './Navbar.module.css'
import DcLogo from '../../utils/assets/dc-logo.png';
import DclogoAzul from '../../utils/assets/dc-logo-azul.png';
import JlLogo from '../../utils/assets/jl-logo.png';


const NavBar = () => {
    return (
        
        <nav className={styles["navbar"]}>

        <img src={DclogoAzul} className={styles["imagem-logo"]} alt="logo-dc" />

        <a className={styles["contribuir"]} title="Entre em contato com nos caso queira Contribuir" href="#contribuir">
            Quer Contribuir?
        </a>
        <a className={styles["sobre"]} href="#sobreDc">
            Sobre a DC
        </a>

        <img src={JlLogo} className={styles["jl"]} alt="logo-jl" />


        <nav className={styles["container"]}>
            
                    <a onclick="login()">
                        Já é Membro?
                    </a>
                    <a href="./cadastro.html">
                        Junte-se a Liga
                    </a>
        </nav>
        
        </nav>
    );
};

// Exporta o componente NavBar para que possa ser usado em outras partes da aplicação.
export default NavBar;
