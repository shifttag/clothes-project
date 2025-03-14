import { css, keyframes } from "@emotion/react";

export const wrap = css`
  display: flex;
  background-color: #fff;
  align-items: center;
  gap: 15px;
`

export const webp = css`
  display: flex;
  width: 100px;
  height: 80px;
`

export const atag = css`
  color: #000;
  text-decoration: none;
  font-size: 13.3333px;
  font-family: 'Arial';
`

export const button = css`
  background-color: #fff;
  color: #000;
  border: none;
  padding: 0;
  cursor: pointer;

`

export const linkContainer = css`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-right: 20px;
`

export const nav = css`
  display: flex;
  flex-shrink: 1;
`

export const site_header_search = css`
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  gap: 40px;
  margin-right: 40px;
`

export const iconAnimation = css`
  transition: transform 0.1s ease-in-out;
`;

export const rotatedIcon = css`
  transform: rotate(90deg);
`;