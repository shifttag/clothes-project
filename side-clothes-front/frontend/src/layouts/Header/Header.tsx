/** @jsxImportSource @emotion/react */
import React, { useState } from "react";
import * as css from "../../styles/MainStyle";
import logo from "../../images/logo.png";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import SearchIcon from "@mui/icons-material/Search";
import CloseIcon from "@mui/icons-material/Close";

export default function Header() {
  const [isShopExpanded, setIsShopExpanded] = useState(false);
  const [isSupportExpanded, setIsSupportExpanded] = useState(false);
  const [isSearchExpanded, setIsSearchExpanded] = useState(false);

  const handleShopIconClick = () => {
    setIsShopExpanded(!isShopExpanded);
    setIsSupportExpanded(false);
  };

  const handleSupportIconClick = () => {
    setIsSupportExpanded(!isSupportExpanded);
    setIsShopExpanded(false);
  };

  const handleSearch = () => {
    setIsSearchExpanded(!isSearchExpanded);
  };

  const handleBackgroundClick = () => {
    setIsSearchExpanded(false);
  };

  const handleCart = () => {
    alert("장바구니 기능은 준비 중입니다.");
  };

  return (
    <header>
      <div css={css.wrap}>
        <div css={css.webp}>
          <a href="/home">
            <img src={logo} alt="오류" />
          </a>
        </div>
        <div css={css.nav}>
          <div css={css.linkContainer}>
            <a href="/" css={css.atag}>
              SHOP
            </a>
            <button css={css.button} onClick={handleShopIconClick}>
              <ChevronRightIcon
                css={[css.iconAnimation, isShopExpanded && css.rotatedIcon]}
              />
            </button>
          </div>
          <div css={css.linkContainer}>
            <a href="/" css={css.atag}>
              SUPPORT
            </a>
            <button css={css.button} onClick={handleSupportIconClick}>
              <ChevronRightIcon
                css={[css.iconAnimation, isSupportExpanded && css.rotatedIcon]}
              />
            </button>
          </div>
        </div>
        <div css={css.site_header_search}>
          <div>
            <button css={css.button} onClick={handleSearch}>
              SEARCH
            </button>
          </div>
          <div>
            <button css={css.button} onClick={handleCart}>
              BAG
            </button>
          </div>
        </div>
      </div>
      {isShopExpanded && (
        <div css={css.category}>
          <div>
            <a href="/" css={css.shoptag}>
              SHOP ALL
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              OUTERWEAR
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              KNITWEAR
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              JACKET & VEST
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              T-SHIRT
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              SHIRT
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              PANTS
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              ACCESSORIES
            </a>
          </div>
        </div>
      )}
      {isSupportExpanded && (
        <div css={css.category}>
          <div>
            <a href="/" css={css.shoptag}>
              CONTACT US
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              FAQ
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              SHIPPING
            </a>
          </div>
          <div>
            <a href="/" css={css.shoptag}>
              RETURNS
            </a>
          </div>
        </div>
      )}
      {isSearchExpanded && (
        <div css={css.modalBackground} onClick={handleBackgroundClick}>
          <div
            css={css.searchModalContainer}
            onClick={(e) => e.stopPropagation()}
          >
            <div css={css.searchModal}>
              <SearchIcon />
              <input
                type="text"
                placeholder="검색하기"
                css={css.headerInputtag}
              />
              <div onClick={handleBackgroundClick}>
                <CloseIcon css={css.closeIcon} />
              </div>
            </div>
          </div>
        </div>
      )}
    </header>
  );
}
