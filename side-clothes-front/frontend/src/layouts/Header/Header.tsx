/** @jsxImportSource @emotion/react */
import React from "react";
import * as css from "../../styles/MainStyle";
import logo from "../../images/logo.png";
import ChevronRightIcon from '@mui/icons-material/ChevronRight';

export default function Header() {
  return (
    <header>
      <div css={css.wrap}>
        <div css={css.webp}>
          <img src={logo} alt="오류" />
        </div>
        <div>
          <div>
            <a href="/" css={css.atag}>
              SHOP
            </a>
            <button css={css.button}>
              <ChevronRightIcon />
            </button>
          </div>
        </div>
      </div>
    </header>
  );
}
