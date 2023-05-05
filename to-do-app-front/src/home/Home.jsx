import Tarea from "../components/Tarea"
import TareaForm from "../components/TareaForm"

const Home = () => {
  return (
    <section className="home">
      <div className="tareas-container">
        <section className="todo">
          <h2>Tareas no completadas</h2>
          <Tarea />
          <Tarea />
          <Tarea />
          <Tarea />
        </section>
        <section className="completadas">
          <h2>Tareas completadas</h2>
          <Tarea />
          <Tarea />
          <Tarea />
          <Tarea />
        </section>
      </div>
      <TareaForm />
    </section>
  )
}

export default Home