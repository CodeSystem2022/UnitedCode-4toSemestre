import express from "express"; 
import morgan from "morgan";
import tareasRoutes from "./router/tareas.routes.js"
import authRoutes from "./router/auth.routes.js"
import cookieParser from "cookie-parser"

const app = express();

// middlewares (convierte los datos en objetos de javascript)
app.use(morgan("dev"));
app.use(cookieParser());
app.use(express.json());
app.use(express.urlencoded({extended: false})); 

app.get("/",(req, res) => res.json({message: "Bienvenido a mi proyecto"}));
app.use('/api', tareasRoutes);
app.use('/api', authRoutes);

// manejando errores
app.use((err, req,res,next) => { 
    res.status(500).json({
        status: "error",
        message: err.message
    });
});
 
export default app;
