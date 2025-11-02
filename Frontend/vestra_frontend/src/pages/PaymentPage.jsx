import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { placeOrder } from "../api"; 
import API from "../api";

export default function PaymentPage() {
  const { state } = useLocation();
  const navigate = useNavigate();

  const {
    cart = [],
    totalPrice = 0,
    userEmail = localStorage.getItem("email") || "guest@vestra.com",
  } = state || {};

  const loadRazorpayScript = () => {
    return new Promise((resolve) => {
      const script = document.createElement("script");
      script.src = "https://checkout.razorpay.com/v1/checkout.js";
      script.onload = () => resolve(true);
      script.onerror = () => resolve(false);
      document.body.appendChild(script);
    });
  };

  // ✅ Handle Razorpay Payment
  const handleRazorpayPayment = async () => {
    const res = await loadRazorpayScript();
    if (!res) {
      alert("❌ Failed to load Razorpay SDK.");
      return;
    }

    const options = {
      key: "rzp_live_x6EMYym8jXLqQ7", // 🧡 Replace with your Razorpay key
      amount: totalPrice * 100, // Convert ₹ to paise
      currency: "INR",
      name: "Vestra Store",
      description: "Secure Payment via Razorpay",
      handler: async function (response) {
        const orderData = {
          userEmail,
          totalAmount: totalPrice,
          paymentMethod: "Razorpay",
          status: "PAID",
          razorpayPaymentId: response.razorpay_payment_id,
          razorpayOrderId: response.razorpay_order_id || "N/A",
          razorpaySignature: response.razorpay_signature || "N/A",
          orderItems: cart.map((item) => ({
            productName: item.name,
            quantity: item.quantity || 1,
            price: item.price,
          })),
        };

        try {
          await placeOrder(orderData);
          alert("✅ Payment Successful & Order Saved!");
          navigate("/payment/orders", { state: { ...orderData } });
        } catch (err) {
          console.error("❌ Error saving order:", err);
          alert("Error saving order details!");
        }
      },
      prefill: {
        name: "Vestra User",
        email: userEmail,
      },
      theme: { color: "#78a9d1ff" },
    };

    const paymentObject = new window.Razorpay(options);
    paymentObject.on("payment.failed", () => alert("❌ Payment Failed. Try Again."));
    paymentObject.open();
  };

  // ✅ Handle Cash on Delivery
  const handleCOD = async () => {
    const orderData = {
      userEmail,
      totalAmount: totalPrice,
      paymentMethod: "Cash on Delivery",
      status: "PENDING",
      orderItems: cart.map((item) => ({
        productName: item.name,
        quantity: item.quantity || 1,
        price: item.price,
      })),
    };

    try {
      await placeOrder(orderData);
      alert("✅ COD Order Placed Successfully!");
      navigate("/payment/orders", { state: { ...orderData } });
    } catch (err) {
      console.error("❌ Error saving COD order:", err);
    }
  };

  // ✅ Handle Empty Cart
  if (!cart.length) {
    return (
      <div className="text-center py-5">
        <h4>No items in your cart!</h4>
        <button className="btn btn-primary mt-3" onClick={() => navigate("/")}>
          Back to Shop
        </button>
      </div>
    );
  }

  return (
    <div className="container py-5">
      <h3 className="fw-bold text-center mb-4">💳 Choose Payment Option</h3>

      <div className="card mx-auto shadow-sm p-4" style={{ maxWidth: "600px" }}>
        <h5 className="mb-3 text-start">🛍️ Order Summary</h5>

        <ul className="list-group mb-4">
          {cart.map((item) => (
            <li key={item.id} className="list-group-item d-flex justify-content-between">
              <span>
                {item.name} <small className="text-muted">({item.category})</small>
              </span>
              <span className="fw-bold text-success">₹{item.price}</span>
            </li>
          ))}
        </ul>

        <h5 className="fw-bold text-end mb-4">
          Total: <span className="text-success">₹{totalPrice}</span>
        </h5>

        <button className="btn btn-primary w-100 mb-2" onClick={handleRazorpayPayment}>
          💳 Pay with Razorpay
        </button>

        <button className="btn btn-outline-dark w-100" onClick={handleCOD}>
          💵 Cash on Delivery
        </button>
      </div>
    </div>
  );
}
