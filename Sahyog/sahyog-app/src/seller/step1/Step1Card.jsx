import React from "react";
import "./Step1Card.css";
import clothes from "./img/dupatta._SY530_QL85_.jpg";
import utensils from "./img/utensils.jpeg";
import decoratives from "./img/decoratives.jpg";
import agriculture from "./img/Agriculture.jpeg";

function Step1Card({ Card }) {
  let Title = Card.Title;

  let Thumbnail;
  if (Card.Thumbnail === "Agriculture") {
    Thumbnail = agriculture;
  } else if (Card.Thumbnail === "Clothes") {
    Thumbnail = clothes;
  } else if (Card.Thumbnail === "Utensils") {
    Thumbnail = utensils;
  } else if (Card.Thumbnail === "Decoratives") {
    Thumbnail = decoratives;
  }
  return (
    <div className="col-md">
      <div className="card" style={{ width: "18rem" }}>
        <img
          src={Thumbnail}
          alt="what"
          className="card-img-top"
          style={{ width: "100%", height: "220px" }}
        />
        <div className="card-body">
          <h5 className="card-title">{Title}</h5>

          <a
            href={"/step2/" + Title}
            className="btn btn-outline-success"
            style={{ marginLeft: "12rem" }}
          >
            Visit
          </a>
        </div>
      </div>
    </div>
  );
}

export default Step1Card;
