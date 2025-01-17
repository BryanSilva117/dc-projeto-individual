
import Rotas from "./routes";

import 'react-toastify/dist/ReactToastify.css';

import { ToastContainer } from 'react-toastify';


function App() {
  return (
    <>
      <Rotas />
      <ToastContainer />
    </>
  );
}

// Exporta o componente App para que possa ser utilizado em outras partes da aplicação
export default App;