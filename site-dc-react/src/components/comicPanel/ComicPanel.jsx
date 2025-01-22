import React from "react";
import styles from "./ComicPanel.module.css";

const ComicPanel = ({ title, text, image, reverse }) => {
  return (
    <div className={`${styles.panel} ${reverse ? styles.reverse : ""}`}>
      <div className={styles.imageContainer}>
        <img src={image} alt={title} />
      </div>
      <div className={styles.textContainer}>
        <h2>{title}</h2>
        <p>{text}</p>
      </div>
    </div>
  );
};

export default ComicPanel;
