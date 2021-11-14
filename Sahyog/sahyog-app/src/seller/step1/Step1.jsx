import React from "react";
import Step1Card from "./Step1Card";
import Step1DataEnglish from "./Step1DataEnglish";
import Step1DataHindi from "./Step1DataHindi";
import "./Step1.css";
import { useParams } from "react-router";

function Step1() {
  let cardList = new Array();
  const lang = useParams();
  console.log(lang.lang);
  switch (lang) {
    case "English":
      cardList = Step1DataEnglish;
      break;

    case "Hindi":
      cardList = Step1DataHindi;
      break;
  }
  return (
    <div className="container mx-auto mt-4">
      <div className="row">
        {cardList.map((listItem) => {
          return (
            <div className="col-sm">
              <Step1Card Card={listItem} />
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default Step1;
