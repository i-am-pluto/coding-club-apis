import play from "../assets/img/play-button.png";
import React from "react";
import "./StartSelling.css";

function StartSelling() {
  return (
    <div>
      <hr />
      <h1 style={{ marginLeft: "20px" }}>Start Selling</h1>
      <hr />
      <p style={{ marginLeft: "10px" }}>
        Language/भाषा :
        <input
          type="radio"
          id="English"
          name="fav_language"
          value="English"
          style={{ marginLeft: "10px" }}
        />
        <label for="English">English</label>
        <input
          type="radio"
          id="Hindi"
          name="fav_language"
          value="Hindi"
          style={{ marginLeft: "10px" }}
        />
        <label for="Hindi">हिन्दी</label>
      </p>
      <hr />
      <center>
        <a href="/seller/step1" className="btn">
          <img
            src={play}
            className="zoom"
            style={{
              marginTop: "150px",
              width: "250px",
              marginBottom: "100px",
            }}
          />
        </a>
      </center>
    </div>
  );
}

export default StartSelling;
