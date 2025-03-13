import React from "react";
import "./App.css";
import Main from "./views/Main/Main";
import { Route, Routes } from "react-router-dom";
import { HOME_PAGE } from "./constants";
import Header from "./layouts/Header/Header";

function App() {
  return (
    <>
      <div>
        <Header />
        <main>
          <Routes>
            <Route path={HOME_PAGE} element={<Main />} />
          </Routes>
        </main>
      </div>
    </>
  );
}

export default App;
