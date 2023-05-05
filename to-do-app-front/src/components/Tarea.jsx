import { MdDone } from 'react-icons/md'
import { RxCross1 } from 'react-icons/rx'

const Tarea = () => {
  return (
    <div className="tarea">
      <div className="info-tarea">
        <h3>Nombre</h3>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Porro eos tenetur dolore magnam. Ut, enim? Cum, tempore illo excepturi corporis eos illum repellendus maxime quibusdam maiores, quaerat neque adipisci voluptate?</p>
      </div>
      <div className="acciones-tarea">
        <div className="completar">
          <MdDone size={30}/>
        </div>
        <div className="borrar">
          <RxCross1 size={30} />
        </div>
      </div>
    </div>
  )
}

export default Tarea