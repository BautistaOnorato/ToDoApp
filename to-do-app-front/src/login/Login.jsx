import { useState } from 'react'
import { BsEye, BsEyeSlash } from 'react-icons/bs'

const Login = () => {
  const [verPass, setVerPass] = useState(false);

  const toggleVerPass = () => {
    setVerPass(!verPass)
  }
  return (
    <section className='registro'>
      <h1>Iniciar sesión</h1>
      <form action="" className="registro-form">
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
        <button type="submit">Iniciar sesión</button>
      </form>
    </section>
  )
}

export default Login