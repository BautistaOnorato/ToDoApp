import './App.css'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Registro from './registro/Registro'
import Home from './home/Home'
import Layout from './layout/Layout'
import Login from './login/Login';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route element={<Registro />} path={'/registro'} />
          <Route element={<Login />} path={'/login'} />
          <Route element={<Home />} path={'/'} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
