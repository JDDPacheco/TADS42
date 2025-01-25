import axios from "axios"
import { useEffect, useState } from "react"

/**export function Dados(){
    [dados, setDados] = useState([])

    useEffect(()=>{
        const fetchData = async () => {
            try{
                const response = await axios.get("http://192.186.0.4:8080/api/pessoa",);
                setDados(response.data)
            }catch(err){
                console.log("\nErro desconhecido!!!\n")
            }
        }
        fetchData();
    },[dados])
    const listaDados = dados.map((item) => {
        return item.nome
    })
    return(
    <div>
        response.data
        listaDados
    </div>
    )
}*/

async function getAxios() {
    try {
        const response = await axios.get("http://192.168.0.4:8080/api/pessoa",{});
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.error("Erro ao fazer a requisição:", error);
        throw error;
    }
}


const resposta = await getAxios();
console.log("primeiro dado:", resposta[0].id);



export const chartData = {
    labels: ['id pessoa 1', 'id pessoa 2', 'id pessoa 3',],
    datasets: [
      {
        label: 'id pessoa',
        data: [resposta[0].id, resposta[1].id, resposta[2].id],
        backgroundColor: 'rgba(75, 192, 192, 0.6)',
      },
    ],
  };
  
  export const chartOptions = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'id das Pessoas',
      },
    },
  };