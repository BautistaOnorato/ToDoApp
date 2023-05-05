import { useState } from 'react'
import { BsEye, BsEyeSlash } from 'react-icons/bs'

const Registro = () => {
  const [verPass, setVerPass] = useState(false);

  const toggleVerPass = () => {
    setVerPass(!verPass)
  }

  return (
    <section className='registro'>
      <h1>Registro</h1>
      <form action="" className="registro-form">
        <fieldset>
          <label htmlFor="nombre">Nombre</label>
          <input className="input-form" type="text" placeholder="Juan" id="nombre" />
        </fieldset>
        <fieldset>
          <label htmlFor="">Apellido</label>
          <input className="input-form" type="text" placeholder="Gomez" id="apellido" />
        </fieldset>
        <fieldset>
          <label htmlFor="email">Email</label>
          <input className="input-form" type="email" placeholder="juangomez@gmail.com" id="email" />
        </fieldset>
        <fieldset>
          <label htmlFor="contraseña">Contraseña</label>
          <input type={verPass ? "text" : "password"} className="input-form" id="contraseña" />
          {
            verPass ? <BsEye size={24} onClick={toggleVerPass} /> : <BsEyeSlash size={24} onClick={toggleVerPass} />
          }
        </fieldset>
        <fieldset>
          <label htmlFor="repetir-contraseña">Confirmar contraseña</label>
          <input className="input-form" type={verPass ? "text" : "password"} id="repetir-contraseña" />
          {
            verPass ? <BsEye size={24} onClick={toggleVerPass} /> : <BsEyeSlash size={24} onClick={toggleVerPass} />
          }
        </fieldset>
        <button type="submit">Registrarse</button>
      </form>
    </section>
  )
}

export default Registro