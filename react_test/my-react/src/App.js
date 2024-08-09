// App.css 적용하기 (내부 css)
import './App.css'
import { useOutlet } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.css'
import BsNavBar from './components/BsNavBar';
import LoginModal from './pages/LogInModal';
import { useSelector } from 'react-redux';

//함수형 component
function App() {
  // 현재 route된 정보를 출력해주는 book
  const currentOutlet = useOutlet() 
  const loginModal = useSelector(state=>state.loginModal)

  return (
    <>
      <BsNavBar />
      <div className="container">
        <div>{currentOutlet}</div>
      </div>
      <LoginModal show={loginModal.show} message={loginModal.message}/>
    </>
  );
}

//외부에서 App.js 를 import 하면 App 함수를 사용할수 있다. (src/index.js)
export default App;
