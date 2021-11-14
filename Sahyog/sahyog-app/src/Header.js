import React from 'react'

function Header() {
    return (
      <div>
        <nav className="navbar navbar-light navbar-expand-md navigation-clean-button">
          <div className="container">
            <a className="navbar-brand" href="#">
              Sahyog
            </a>
            <button
              data-bs-toggle="collapse"
              className="navbar-toggler"
              data-bs-target="#navcol-1"
            >
              <span className="visually-hidden">Toggle navigation</span>
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navcol-1">
              <ul className="navbar-nav me-auto">
                <li className="nav-item"></li>
                <li className="nav-item"></li>
              </ul>
              <span className="navbar-text actions">
                {" "}
                <a className="btn btn-light action-button" role="button" href="#">
                  EXISTING USER
                </a>
              </span>
            </div>
          </div>
        </nav>
      </div>
    );
}

export default Header
