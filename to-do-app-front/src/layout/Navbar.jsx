import { useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import { RiMenu3Line, RiCloseLine } from 'react-icons/ri'

const Navbar = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [toggleMenu, setToggleMenu] = useState(false)

  const handleToggle = () => {
    setToggleMenu(!toggleMenu)
  }

  return (
    <header>
      <div className="titulo">
        <h2>To Do App</h2>
      </div>
      {
        location.pathname !== '/' ? (
          <nav>
            <div className="btns-navbar">
              {location.pathname !== '/registro' && (<p onClick={() => navigate('/registro')}>Regsitro</p>)}
              {location.pathname !== '/login' && (<p onClick={() => navigate('/login')}>Iniciar sesión</p>)}
            </div>
            <div className="menu">
              {
                toggleMenu 
                  ? <RiCloseLine color='#fff' size={27} onClick={handleToggle} />
                  : <RiMenu3Line color='#fff' size={27} onClick={handleToggle} />
              }
              {
                toggleMenu && (
                  <div className="menu-container scale-up-center">
                    {location.pathname !== '/registro' && (<p onClick={() => {
                      navigate('/registro')
                      handleToggle()
                    }}>Regsitro</p>)}
                    {location.pathname !== '/login' && (<p onClick={() => {
                      navigate('/login')
                      handleToggle()
                    }}>Iniciar sesión</p>)}
                  </div>
                )
              }
            </div>
          </nav>
        ) : <p className="saludo" style={{ paddingRight: "2rem", cursor: "default" }}>Bienvenido, Juan</p>
      }
    </header>
  )
}

export default Navbar