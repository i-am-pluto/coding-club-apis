import "./App.css";
import "./assets/bootstrap/css/bootstrap.min.css";
import "./assets/fonts/ionicons.min.css";
import "./assets/css/Button-Ripple-Effect-Animation-Wave-Pulse.css";
import "./assets/css/Footer-Dark.css";
import "./assets/css/Navigation-with-Button.css";
import "./assets/css/Soft-ui-Navbar.css";
import "./assets/css/styles.css";

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Routes,
  Redirect,
} from "react-router-dom";
// import "./assets/bootstrap/js/bootstrap.min";
import "bootstrap/dist/js/bootstrap";
import "./assets/bootstrap/css/bootstrap.min.css";
import Header from "./Header";
import Home from "./home/Home";
import Footer from "./Footer";
import StartSelling from "./seller/StartSelling";
import Step1 from "./seller/step1/Step1";
function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Switch>
          <Route path="/home">
            <Home />
          </Route>
          <Route exact path="/seller">
            <StartSelling />
          </Route>
          <Route path="/seller/step1/:lang">
            <Step1 />
          </Route>
          <Route path="/seller/step2"></Route>
          <Route path="/seller/step3"></Route>
          <Route path="/buyer"></Route>
          <Route exact path="/">
            <Redirect to="/home" />
          </Route>
        </Switch>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
