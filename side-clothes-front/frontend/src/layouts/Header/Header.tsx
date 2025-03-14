/** @jsxImportSource @emotion/react */
import React, { useState } from "react";
import * as css from "../../styles/MainStyle";
import logo from "../../images/logo.png";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore"; //

export default function Header() {
  const [isShopExpanded, setIsShopExpanded] = useState(false);
  const [isSupportExpanded, setIsSupportExpanded] = useState(false);

  const handleShopIconClick = () => {
    setIsShopExpanded(!isShopExpanded);
    setIsSupportExpanded(false); // SUPPORT 상태 초기화
  };

  const handleSupportIconClick = () => {
    setIsSupportExpanded(!isSupportExpanded);
    setIsShopExpanded(false); // SHOP 상태 초기화
  };

  const handleSearch = () => {
    alert("검색 기능은 준비 중입니다.");
  }

  return (
    <header>
      <div css={css.wrap}>
        <div css={css.webp}>
          <img src={logo} alt="오류" />
        </div>
        <div css={css.nav}>
          <div css={css.linkContainer}>
            <a href="/" css={css.atag}>
              SHOP
            </a>
            <button css={css.button} onClick={handleShopIconClick}>
              <ChevronRightIcon css={[css.iconAnimation, isShopExpanded && css.rotatedIcon]} />
            </button>
          </div>
          <div css={css.linkContainer}>
            <a href="/" css={css.atag}>
              SUPPORT
            </a>
            <button css={css.button} onClick={handleSupportIconClick}>
              <ChevronRightIcon css={[css.iconAnimation, isSupportExpanded && css.rotatedIcon]} />
            </button>
          </div>
        </div>
        <div css={css.site_header_search}>
          <div>
            <button css={css.button} onClick={handleSearch}>SEARCH</button>
          </div>
          <div>
            <button css={css.button}>BAG</button>
          </div>
        </div>
      </div>
    </header>
  );
}
