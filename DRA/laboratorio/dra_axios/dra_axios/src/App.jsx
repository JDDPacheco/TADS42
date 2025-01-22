import React from 'react';
import './App.css';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';
import { Bar } from 'react-chartjs-2';
import { chartData, chartOptions } from './requicaoAxios'; // Importe o arquivo de configuração

// Registre os componentes do Chart.js
ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const ChartComponent = ({ chartData, chartOptions }) => {
  return <Bar data={chartData} options={chartOptions} />;
};

function App() {
  return (
    <div>
      <h1>My Chart</h1>
      {/* Envie os dados e as opções como props */}
      <ChartComponent chartData={chartData} chartOptions={chartOptions} />
    </div>
  );
}

export default App;