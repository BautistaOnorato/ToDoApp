import React from 'react'

const TareaForm = () => {
  return (
    <div className="tarea-form-container">
      <h2>Crear tarea</h2>
      <form action="" className='tarea-form'>
        <fieldset>
          <label htmlFor="titulo">Titulo</label>
          <input type="text" id='titulo' className='input-tarea' placeholder='Cocinar' />
        </fieldset>
        <fieldset>
          <label htmlFor="descripcion">Descripción</label>
          <textarea id="descripcion" className='input-tarea' minLength={1} maxLength={250} placeholder='Maximo 250 caracteres'></textarea>
        </fieldset>
        <button type="submit">Crear tarea</button>
      </form>
    </div>
  )
}

export default TareaForm