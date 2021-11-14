import React from "react";
import market from "../assets/img/market.png";
import customer from "../assets/img/customer.png";
function Home() {
  return (
    <div>
      <div className="container" style={{ height: "172%" }}>
        <div className="row">
          <div className="col-md" style={{ height: "100%", marginTop: "32px" }}>
            <div className="text-center m-3">
              <a
                className="btn btn-primary align-content-center justify-content-md-center"
                type="button"
                style={{
                  marginTop: "auto",
                  marginRight: "auto",
                  width: "550px",
                  height: "100%",
                  color: "var(--bs-gray-100)",
                  background: "var(--bs-red)",
                }}
                href="/buyer"
              >
                BUYER
                <img src={customer} style={{ width: "auto", height: "100%" }} />
              </a>
            </div>
          </div>
          <div className="col-md" style={{ height: "100%", marginTop: "32px" }}>
            <div className="text-center m-3">
              <a
                className="btn btn-primary align-content-center justify-content-md-center"
                type="button"
                style={{
                  marginTop: "auto",
                  marginRight: "auto",
                  width: "550px",
                  height: "100%",
                  background: "var(--bs-gray-800)",
                }}
                href="/seller"
              >
                SELLER
                <img src={market} style={{ width: "auto" }} />
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
