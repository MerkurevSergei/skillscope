import { useEffect, useState } from 'react';
import { Activity, CalendarClock, CheckCircle2, ClipboardList, UsersRound } from 'lucide-react';
import { getBackendHealth, type BackendHealth } from './api/client';
import './styles.css';

type HealthState =
  | { status: 'loading' }
  | { status: 'online'; data: BackendHealth }
  | { status: 'offline'; message: string };

const pipelineItems = [
  { label: 'Candidates', value: '24', icon: UsersRound },
  { label: 'Scheduled', value: '8', icon: CalendarClock },
  { label: 'Scorecards', value: '16', icon: ClipboardList },
  { label: 'Completed', value: '12', icon: CheckCircle2 }
];

function App() {
  const [health, setHealth] = useState<HealthState>({ status: 'loading' });

  useEffect(() => {
    getBackendHealth()
      .then((data) => setHealth({ status: 'online', data }))
      .catch((error: unknown) => {
        const message = error instanceof Error ? error.message : 'Backend is unavailable';
        setHealth({ status: 'offline', message });
      });
  }, []);

  return (
    <main className="app-shell">
      <nav className="topbar" aria-label="Primary">
        <div className="brand">
          <Activity size={24} aria-hidden="true" />
          <span>SkillScope</span>
        </div>
        <div className={`status-pill status-pill--${health.status}`}>
          <span className="status-dot" aria-hidden="true" />
          {health.status === 'online' ? 'Backend online' : health.status === 'offline' ? 'Backend offline' : 'Checking'}
        </div>
      </nav>

      <section className="workspace">
        <div className="intro">
          <p className="eyebrow">Interview platform</p>
          <h1>Manage technical interviews from brief to feedback.</h1>
          <p>
            A clean starting point for candidates, sessions, questions, evaluations, and reviewer workflow.
          </p>
        </div>

        <div className="metrics-grid" aria-label="Interview pipeline">
          {pipelineItems.map((item) => {
            const Icon = item.icon;
            return (
              <article className="metric-card" key={item.label}>
                <Icon size={22} aria-hidden="true" />
                <div>
                  <span>{item.label}</span>
                  <strong>{item.value}</strong>
                </div>
              </article>
            );
          })}
        </div>

        <section className="panel" aria-label="Backend connection">
          <div>
            <h2>API connection</h2>
            <p>
              {health.status === 'online'
                ? `${health.data.service} responded at ${new Date(health.data.timestamp).toLocaleString()}`
                : health.status === 'offline'
                  ? health.message
                  : 'Checking backend status...'}
            </p>
          </div>
        </section>
      </section>
    </main>
  );
}

export default App;
