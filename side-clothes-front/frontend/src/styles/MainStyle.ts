import { css } from "@emotion/react";

export const wrap = css`
  display: flex;
  background-color: #fff;
  align-items: center;
  gap: 15px;
`;

export const webp = css`
  & > a {
    display: flex;
    width: 100px;
    height: 80px;
  }
`;

export const atag = css`
  color: #000;
  text-decoration: none;
  font-size: 13.3333px;
  font-family: "Arial";
`;

export const button = css`
  background-color: #fff;
  color: #000;
  border: none;
  padding: 0;
  cursor: pointer;
`;

export const linkContainer = css`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-right: 20px;
`;

export const nav = css`
  display: flex;
  flex-shrink: 1;
`;

export const site_header_search = css`
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  gap: 40px;
  margin-right: 40px;
`;

export const iconAnimation = css`
  transition: transform 0.1s ease-in-out;
`;

export const rotatedIcon = css`
  transform: rotate(90deg);
`;

export const shoptag = css`
  color: #757575;
  text-decoration: none;
  font-size: 13.3333px;
  font-family: "Arial";

  &:hover {
    color: #000;
    text-decoration: underline;
  }
`;

export const category = css`
  display: flex;
  gap: 40px;
  margin-left: 115px;
`;

export const searchModalContainer = css`
  position: fixed;
  width: 100%;
  height: 70px;
  top: 80px;
  background-color: #fff;
`

export const searchModal = css`
  display: flex;
  justify-content: left;
  align-items: center;
  margin-left: 110px;
  margin-top: 10px;
  gap: 10px;
`

export const modal = css`
  display: none;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  justify-content: center;
  align-items: center;
  pointer-events: none;
`;

export const modalOpen = css`
  display: flex;
  pointer-events: auto;
`;

export const modalBackground = css`
  position: fixed;
  top: 80px;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #666666;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const headerInputtag = css`
  border: none;
  padding: 15px;
  flex-grow: 1;
  outline: none;
`

export const closeIcon = css`
  display: none;
  margin-right: 40px;
  max-width: 1024px;
  cursor: pointer;

  :hover {
    color: rgba(69, 69, 69, 0.5);
  }
  
  @media (min-width: 1024px) {
    display: block;
  }
`

